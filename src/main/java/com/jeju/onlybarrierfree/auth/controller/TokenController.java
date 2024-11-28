package com.jeju.onlybarrierfree.auth.controller;



import com.jeju.onlybarrierfree.auth.jwt.JwtRequestDto;
import com.jeju.onlybarrierfree.auth.jwt.JwtResponseDto;
import com.jeju.onlybarrierfree.auth.jwt.JwtTokenUtils;
import com.jeju.onlybarrierfree.user.entity.UserEntity;
import com.jeju.onlybarrierfree.user.service.UserService;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
@RequestMapping("token")
@RequiredArgsConstructor
public class TokenController {

    private final JwtTokenUtils jwtTokenUtils;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @PostMapping("/issue")
    public JwtResponseDto issueJwt(@RequestBody JwtRequestDto dto)
    {
        UserEntity details = userService.loadUserByEmail(dto.getEmail());

        if(!passwordEncoder.matches(dto.getPassword(), details.getPassword()))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);

        String accessToken = jwtTokenUtils.generateToken(details);


        JwtResponseDto responseDto = new JwtResponseDto();
        responseDto.setAccessToken(accessToken);

        return responseDto;
    }

//    // Refresh Token을 이용해 새로운 Access Token을 발급하는 엔드포인트
//    @PostMapping("/refresh")
//    public JwtResponseDto refresh(@RequestHeader("Authorization") String refreshToken)
//    {
//        refreshToken = refreshToken.substring(7);
//
//        if(!jwtTokenUtils.validate(refreshToken))
//        {
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid refresh token");
//        }
//
//        Claims claims = jwtTokenUtils.parseClaims(refreshToken);
//        String email = claims.getSubject();
//
//        String savedToken = refreshTokenRepository.findByEmail(email);
//
//        if(savedToken == null || !savedToken.equals(refreshToken))
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Refresh token not found");
//
//        UserEntity details = userService.loadUserByEmail(email);
//        String newAccessToken = jwtTokenUtils.generateAccessToken(details);
//
//        JwtResponseDto responseDto = new JwtResponseDto();
//        responseDto.setAccessToken(newAccessToken);
//        responseDto.setRefreshToken(refreshToken);
//        responseDto.setAccessTokenExpiresIn(System.currentTimeMillis() + (60 * 60 * 1000));
//
//        return responseDto;
//    }
//
//    @PostMapping("/logout")
//    public ResponseEntity<Void> logout(@RequestHeader("Authorization") String bearerToken)
//    {
//        String token = bearerToken.substring(7);
//        Claims claims = jwtTokenUtils.parseClaims(token);
//        String email = claims.getSubject();
//
//        refreshTokenRepository.deleteByEmail(email);
//
//        return ResponseEntity.ok().build();
//    }


    @GetMapping("/validate")
    public Claims validateToken(@RequestParam("token") String token)
    {
        if(!jwtTokenUtils.validate(token))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);

        return jwtTokenUtils.parseClaims(token);
    }



}
