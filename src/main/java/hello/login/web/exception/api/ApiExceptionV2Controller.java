package hello.login.web.exception.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hello.login.web.exception.exception.UserException;
import hello.login.web.exception.exhandler.ErrorResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api2")
public class ApiExceptionV2Controller {

	@GetMapping("/members/{id}")
	public MemberDto getMember(@PathVariable("id") String id) {
		if(id.equals("ex")) {
			throw new RuntimeException("잘못된 사용자");
		}
		if(id.equals("bad")) {
			throw new IllegalArgumentException("잘못된 요청");
		}
		if(id.equals("user-ex")) {
			throw new UserException("사용자 오류");
		}

		return new MemberDto(id, "hello" + id);
	}

	@GetMapping("/default-handler-ex")
	public String defaultException(@RequestParam Integer data) {
		return "ok";
	}

	@Data
	@AllArgsConstructor
	static class MemberDto {
		private String memberId;
		private String name;
	}
}
