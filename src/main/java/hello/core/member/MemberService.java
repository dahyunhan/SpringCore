package hello.core.member;

public interface MemberService {
    //회원 서비스
    void join(Member member);

    Member findMember(Long memberId);

}
