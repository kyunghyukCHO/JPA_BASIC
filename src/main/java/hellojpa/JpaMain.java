package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {

            // 회원 생성
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("helloA");
//            em.persist(member);

            // 회원 수정
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("helloJPA"); // persist 가 필요하지 않습니다. < 변경감지 - 플러시 참조 >

            // 회원 삭제
//            em.remove(findMember);

            // 회원 부분 조회
            // JPQL 을 사용합니다. 이때의 Member 는 객체를 대상으로 query 를 합니다.
            // 즉 대상이 Table 이 아닌 객체 입니다.
//            List<Member> result = em.createQuery("SELECT m FROM Member as m", Member.class)
//                    .setFirstResult(1) // 페이징
//                    .setMaxResults(10) // 객체지향 query 이기 때문에 각 DB의 방언에 맞춰 번역합니다.
//                    .getResultList();

            //영속
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//            em.persist(member1); // 여기까지 컨텍스트에 쌓인다. 실제 DB에 올라가지 않음
//            em.persist(member2);

            //준영속
//            em.detach(member);
//            em.clear();

            //플러쉬
//            Member member = new Member(200, "member200");
//            em.persist(member);
//            em.flush();

            //기본키 매핑
//            Member member = new Member();
//            member.setId("ID_A");
//            member.setUsername("C");
//            em.persist(member);

            // GeneratedValue 매핑
            // IDENTITY 의 경우.. 기본키를 부여하는것은 데이터베이스에 접근해야 알 수 있다.
            // 하지만 영속성 컨테스트에 올라가기 때문에 아직 기본키를 알 수 없다.
            // 이를 해결하기 위해.. IDENTITY 에 한해서 em.persist 시점에 쿼리를 날린다.

            // SEQUENCE 의 경우.. db의 MEMBER_SEQ 에서 부여받을 수 있다
            // persist 할 경우 db에서 pk값을 가져와 id를 부여하고 영속시킨다
            // 네트워크 혼잡을 최적화 시키기 위해 미리 50개의 사이즈만 땡겨옵니다! (allocationSize)
//            Member member = new Member();
//            member.setUsername("C");
//            em.persist(member);

            //연관관계 매핑이 아닌 경우..!
            //객체의 레퍼런스를 반환하는 것이 아닌 id값을 공유함
            //객체지향적인 방법이 아님
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("Member1");
//            member.setTeamId(team.getId());
//            em.persist(member);
//
//            Member findMember = em.find(Member.class, member.getId());
//            Long findTeamId = findMember.getTeamId();
//            Team findTeam = em.find(Team.class, findTeamId);

            //연관관계 매핑 단방향
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("Member1");
//            member.setTeam(team);
//            em.persist(member);
//
//            Member findMember = em.find(Member.class, member.getId());
//            Team team = findMember.getTeam();

            //연관관계 매핑 양방향
            //==========================
            // 1. 외래키가 있는곳이 주인
            // 2. ManyToOne 쪽이 주인
            // 3. 주인객체의 수정이 DB에 반영
            // 4. jpa가 Team 을 자동으로 db에 쿼리해주긴 하지만
            // 5. 양쪽 다 수정하는것을 권장 ----> 편리를 위해 메소드 생성.. Member 클래스 확인
            //==========================
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("Member1");
//            member.changeTeam(team);
//            em.persist(member);
//
//            Member findMember = em.find(Member.class, member.getId());
//            List<Member> members = findMember.getTeam().getMembers();
//
//            for (Member m : members) {
//                System.out.println("m = " + m.getUsername());
//            }


            tx.commit(); // 실제 데이터베이스에 올리는 CODE
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
