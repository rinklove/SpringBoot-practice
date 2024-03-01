package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
//
        tx.begin();
//      이게 정석 코드. 실제로 사용할 땐 스프링이 다 해줌
        try{
//            회원 생성
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("helloA");
//            em.persist(member);

//            회원 조회
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());
//            회원 삭제
//            em.remove(findMember);
//            회원 수정
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("helloJPA");

//            List<Member> result = em.createQuery("select m from Member as m", Member.class).setFirstResult(5).setMaxResults(8).getResultList();
//            //결과 리스트중 5번부터 8번까지 가져와
//
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//                ------------------------------------
//                Member memberA = new Member();
//                memberA.setId(101L);
//                memberA.setName("helloJPA");
//                ------------------------------------
//                System.out.println("before");
//                em.persist(memberA); // -> memberA 객체가 영속성 컨텍스트로 되는 시점.
//                System.out.println("after");

//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);
//            System.out.println(findMember1 == findMember2); //true
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());
//            -----------------------------------------
//            Member member1 = new Member(150L, "A");
//            Member findMember = em.find(Member.class, 150L);
//            findMember.setName("AAA"); //수정할 때는 persist없이 수정만 하면 변경 가능하다.
//
//            em.persist(member1);
//
//            System.out.println("-----------SQL문을 모았다가 마지막에 한번에 한다.---------------");

//            Member member = new Member(200L, "flushing");
//            em.persist(member);
//            em.flush(); // --> 이 시점에서 sql문이 DB로 보내짐
//            System.out.println("--------------------------");

//            Member member = em.find(Member.class, 150l);
//            member.setName("changedAAA");
//
//            em.detach(member); //특정 엔티티만 준영속 상태로 만듬, update 쿼리x
//            em.clear(); // 영속성 컨텍스트를 완전히 초기화
//            em.close(); // 영속성 컨텍스트를 종료
//            Member member2 = em.find(Member.class, 150l);
//------------------------------------------------------------------
//            Member member1 = new Member();
//            member1.setUsername("A");
//
//            Member member2 = new Member();
//            member2.setUsername("B");
//
//            Member member3 = new Member();
//            member3.setUsername("C");
//
//            System.out.println("=================");
////            System.out.println("member.id = " + member.getId()); //null
//            //실제로 insert 쿼리문을 넣음.
//            em.persist(member1); //1, 51
//            em.persist(member2); //메모리
//            em.persist(member3); //메모리
//
////            System.out.println("member.id = " + member.getId()); //1
//            System.out.println("=================");
//            -----------------------------------------------------------
//            연관관계 미매핑 시 데이터 삽입 --> 연관 관계에 있는 테이블 조회가 어려움
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeamId(team.getId()); //이 부분이 객체지향스럽지 못함.
//            em.persist(member);
//
//            Member findMember = em.find(Member.class, member.getId());
//            Long findTeamId = findMember.getTeamId();
//            Team findTeam = em.find(Team.class, findTeamId);
//            ---------------------------------------------------------------
//            연관관계 매핑한 경우의 조회
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.changeTeam(team);
////            team.getMembers().add(member); 연관관계의 주인값을 넣어야함
//            em.persist(member);
//
//
//            em.flush(); //변경사항을 미리 쿼리로 날림()
//            em.clear();
//            ---------------------------------------------------------------

//            //조회
//            Member findMember = em.find(Member.class, member.getId());
//            //참조를 사용해서 연관관계 조회
//            Team findTeam = findMember.getTeam();
//            System.out.println("findTeam = " + findTeam.getName());

//            //연관관계 수정
//            Team newTeam = em.find(Team.class, findTeam.getId());
//            findMember.setTeam(newTeam);
//            -------------------------------------
//            Member findMember = em.find(Member.class, member.getId());
//            List<Member> members = findMember.getTeam().getMembers();
//            for (Member m : members) {
//                System.out.println("member.username = " + m.getUsername());
//            }
//
//            Team findTeam = em.find(Team.class, team.getId());
//            List<Member> members1 = findTeam.getMembers();
//            for (Member m : members1) {
//                System.out.println("member.username = " + m.getUsername());
//            }
//            -------------------------------------
            //일대다 단방향, 단방향은 일대다보단 다대일을 사용하는 것이 더 편함.
//            Member member = new Member();
//            member.setUsername("member1");
//
//            em.persist(member);
//
//             Team team = new Team();
//             team.setName("teamA");
//             team.getMembers().add(member);
//
//             em.persist(team);
//            -------------------------------------
//            상속 관계 매핑
//            Movie movie = new Movie();
//            movie.setDirector("aa");
//            movie.setActor("actorA");
//            movie.setName("바람과 함께 사라지다");
//            movie.setPrice(10000);
//
//            em.persist(movie);
//            em.flush();
//            em.clear();
//
//            //조회 //조인을 알아서 해줌.
//            Movie findMovie = em.find(Movie.class, movie.getId());
//            System.out.println("findMovie = " + findMovie);
//            -------------------------------------
//            MappedSuperclass - 매핑 정보 상속
//            Member member = new Member();
//            member.setCreatedBy("lee");
//            member.setCreatedDate(LocalDateTime.now());
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//            ------------------------------------------
//            프록시
//            Member member1 = new Member();
//            member1.setUsername("hello1");
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("hello2");
//            em.persist(member2);
//
//            em.flush();
//            em.clear();

            //실제 엔티티 객체 조회
//            Member findMember = em.find(Member.class, member.getId());
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getUsername() = " + findMember.getUsername());

            //프록시 사용 시
            System.out.println("-----------------------------------");
//            Member proxyMember = em.getReference(Member.class, member.getId());
//            System.out.println("proxyMember.getClass() = " + proxyMember.getClass()); //proxy클래스
//            System.out.println("proxyMember.getId() = " + proxyMember.getId());
//            System.out.println("proxyMember.getUsername() = " + proxyMember.getUsername());

//            타입 체크시 == 대신 instanceof를 사용헤야함
//            Member m1 = em.find(Member.class, member1.getId());
//            Member m2 = em.find(Member.class, member2.getId());
//            System.out.println("m1 == m2 " + (m1.getClass() == m2.getClass())); //true
//            ------------------------------------------
//            Member m1 = em.find(Member.class, member1.getId());
//            Member m2 = em.getReference(Member.class, member2.getId());
//            System.out.println("m1 == m2 " + (m1.getClass() == m2.getClass())); //false
//            System.out.println("m1 == m2 " + (m1 instanceof Member)); //true
//            System.out.println("m1 == m2 " + (m2 instanceof Member)); //true

            //프록시 인스턴스의 초기화 여부 확인
//            Member member = new Member();
//            member.setUsername("member");
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            Member refMember = em.getReference(Member.class, member.getId());
//            System.out.println("refMember.getClass() = " + refMember.getClass());
////            refMember.getUsername(); //프록시 인스턴스 초기화 코드
//            Hibernate.initialize(refMember); //강제 초기화 코드
//            //true
//            System.out.println("emf.getPersistenceUnitUtil().isLoaded(refMember) = " + emf.getPersistenceUnitUtil().isLoaded(refMember));
            //----------------------------------------------------------------

//            Parent parent = new Parent();
//            Child child1 = new Child();
//            Child child2 = new Child();
//
//            parent.addChild(child1);
//            parent.addChild(child2);
//
//            em.persist(parent);
//            em.persist(child1);
//            em.persist(child2);
//
//            em.flush();
//            em.clear();
//
//            Parent findParent = em.find(Parent.class, parent.getId());
//            em.remove(findParent);
//            ---------------------------------------
            //임베디드 타입

//            Member member = new Member();
//            member.setUsername("hello");
//            member.setAddress(new Address("city", "street", "zipcode"));
//
//            em.persist(member);
//            ---------------------------------------
            //임베디드 타입
//            Address address = new Address("city", "street", "zipcode");
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setAddress(address);
//            em.persist(member);

            //값 불변 --> 값을 복사해서 사용해야함.
//            Address address2 = new Address(address.getCity(), address.getStreet(), address.getZipcode());
//
//            Member member2 = new Member();
//            member2.setUsername("member2");
//            member2.setAddress(address2);
//            em.persist(member2);
//
//            member.getAddress().setCity("newCity");
//            ---------------------------------------
            //값 타입 컬렉션
//            Member member = new Member();
//            member.setUsername("member");
//            member.setAddress(new Address("homeCity", "street", "zipcode"));
//
//            member.getFavoriteFoods().add("chicken");
//            member.getFavoriteFoods().add("coke");
//            member.getFavoriteFoods().add("pizza");
//
//            member.getAddressHistory().add(new AddressEntity("old1", "oldStreet1", "oldZipcode1"));
//            member.getAddressHistory().add(new AddressEntity("old2", "oldStreet2", "oldZipcode2"));
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();

//            System.out.println("================ 조회 start ================");
//            Member findMember = em.find(Member.class, member.getId());

//            List<Address> addressHistory = findMember.getAddressHistory();
//            for(Address address: addressHistory) {
//                System.out.println("address.getCity() = " + address.getCity());
//            }
//            Set<String> favoriteFoods = findMember.getFavoriteFoods();
//            for(String favoriteFood: favoriteFoods) {
//                System.out.println("favoriteFood) = " + favoriteFood);
//            }
//            System.out.println("================ 수정 start ================");
//            Address a = findMember.getAddress();
//            findMember.setAddress(new Address("newCity", a.getStreet(),a.getZipcode()));
//
//            //치킨을 한식으로 변경
//            findMember.getFavoriteFoods().remove("chicken");
//            findMember.getFavoriteFoods().add("한식");

//            findMember.getAddressHistory().remove(new AddressEntity("old1", "oldStreet1", "oldZipcode1"));
//            findMember.getAddressHistory().add(new AddressEntity("new1", "newStreet1", "newZipcode1"));
//            ---------------------------------------
            //JPQL
//            em.createQuery("select m from Member m where m.username  like '%kim%'", Member.class).getResultList();
//
//            //Criteria --> 과정이 좀 복잡한거 같음.. sql스럽지 않음
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Member> query = cb.createQuery(Member.class);
//
//            Root<Member> m = query.from(Member.class);
//            CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("username"), "kim"));
//            em.createQuery(cq);

            //QueryDSL
//            -----------------
            


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
