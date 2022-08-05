package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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
//            findMember.setName("helloJPA");

            // 회원 삭제
//            em.remove(findMember);

            // 회원 부분 조회
            // JPQL 을 사용합니다. 이때의 Member 는 객체를 대상으로 query 를 합니다.
            // 즉 대상이 Table 이 아닌 객체 입니다.
//            List<Member> result = em.createQuery("SELECT m FROM Member as m", Member.class)
//                    .setFirstResult(1) // 페이징
//                    .setMaxResults(10) // 객체지향 query 이기 때문에 각 DB의 방언에 맞춰 번역합니다.
//                    .getResultList();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
