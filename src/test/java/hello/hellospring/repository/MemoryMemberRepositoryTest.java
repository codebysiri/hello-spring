package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 하나의 TEST가 끝날 때마다 공용 DATA를 지워준다.
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {

        Member member = new Member();
        member.setName("SPRING");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void finByName() {

        Member member1 = new Member();
        member1.setName("SPRING1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("SPRING2");
        repository.save(member2);

        Member result = repository.findByName("SPRING1").get();

        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll() {

        Member member1 = new Member();
        member1.setName("SPRING1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("SPRING2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }

}
