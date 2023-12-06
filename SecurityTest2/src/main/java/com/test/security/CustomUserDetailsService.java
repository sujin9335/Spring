package com.test.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.test.domain.CustomUser;
import com.test.domain.MemberDTO;
import com.test.mapper.MemberMapper;

public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private MemberMapper mapper;
	
	//로그인시 입력한 아이디가 여기로 넘어와서 db와 비교후 return으로 인증객체에 정보 대입해줌
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		//DB상에서 회원 정보 읽어서 > 인증 객체 대입 : session에 id 같은거 넣는 작업
		
		//username == 아이디
		MemberDTO dto=mapper.read(username);
		
		//MemberDTO > 시큐리티에서 사용(변환) > CustomUser
		
		return dto != null ? new CustomUser(dto) : null;
	}
	
}
