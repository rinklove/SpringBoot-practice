package jpql;

import org.hibernate.dialect.Oracle12cDialect;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
//
        tx.begin();
//      이게 정석 코드. 실제로 사용할 땐 스프링이 다 해줌
        try{
            Team teamA = new Team();
            teamA.setName("팀A");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("팀B");
            em.persist(teamB);

            em.flush();
            em.clear();

            Member member1 = new Member();
            member1.setUsername("회원1");
            member1.setTeam(teamA);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("회원2");
            member2.setTeam(teamA);
            em.persist(member2);


            Member member3 = new Member();
            member3.setUsername("회원3");
            member3.setTeam(teamB);
            em.persist(member3);


            em.flush();
            em.clear();

            //벌크 연산 -> 한번의 쿼리로 모든 행 update or delete, flush 자동 호출
            int i = em.createQuery("update Member m set m.age = 20")
                    .executeUpdate();

            System.out.println("i = " + i);

            // fetch join
//            String query = "select t from Team t";
//            List<Team> result = em.createQuery(query, Team.class)
//                    .setFirstResult(0)
//                    .setMaxResults(2)
//                    .getResultList();
//            for(Team t : result) {
//                System.out.println("t = " + t.getName() + "| members = " + t.getMembers().size());
//                for(Member b : t.getMembers()) {
//                    System.out.println("-> b = " + b);
//                }
//            }
//            ----------------------
//            List<Member> result = em.createNamedQuery("Member.findByUsername", Member.class)
//                    .setParameter("username", "회원1")
//                    .getResultList();
//            for (Member member : result) {
//                System.out.println("member = " + member);
//            }
//            String query1 = "select locate('de','abcdedfg') From Member m";
//            String query2 = "select size(t.members) From Team t";
//            String query3 = "select function('group_concat', m.username) From Member m";
//            List<Integer> resultList = em.createQuery(query1, Integer.class).getResultList();
//            List<Integer> resultList1 = em.createQuery(query2, Integer.class).getResultList();
//            List<String> resultList2 = em.createQuery(query3, String.class).getResultList();
//
//            for(String u : resultList2) {
//                System.out.println("u = " + u);
//            }
//            for (int i:resultList1) {
//                System.out.println("i = " + i);
//            }
//
//            for(Integer s : resultList) {
//                System.out.println("s = " + s);
//            }
//            String query = "select nullif(m.username, '관리자') from  Member m";
//            List<String> resultList = em.createQuery(query, String.class).getResultList();
//
//            for(String s : resultList) {
//                System.out.println("s = " + s);
//            }
//            TypedQuery<Member> query1 = em.createQuery("select m from Member m", Member.class);
//            TypedQuery<String> query2 = em.createQuery("select m.username, m.age from Member m", String.class);
//            //반환 타입이 명확하지 않음.
//            Query query3 = em.createQuery("select m.username, m.age from Member m");
//            String query = "select m.username, 'HELLO', TRUE from Member m where  m.memberType = :userType";
//            List<Object[]> resultList = em.createQuery(query)
//                    .setParameter( "userType", MemberType.ADMIN)
//                    .getResultList();

//            for(Object o : resultList) {
//                System.out.println("o = " + o);
//            }
            //리스트로 조회
//            List<Member> resultList = query1.getResultList();
            //단일 객체 조회
//            Member singleResult = query1.getSingleResult();
//            --------------------------------
            tx.commit();
//            tx.commit(); //DB에 반영 해주는 코드
        } catch (Exception e) {
            tx.rollback(); //오류가 발생하면 try에 있는코드를 없던것처럼
        } finally {
            em.close();
        }
//        emf.close();
    }

}
