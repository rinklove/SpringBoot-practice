package hello.core.order;

import hello.core.annotation.MainAnnotationPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor //26~30번째 줄과 같은 의미 - final이 붇은 변수로 생성사를 만듦.
public class OrderServiceImpl2 implements OrderService{
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//   private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//   private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
//   --> OCP, DIP를 준수했는가? x -->  인터페이스뿐만 아니라 구현 객체에도 의존 중(DIP 위반)
//   Fix -> Rate로 변경 시 하단 코드를 수정할 필요가 생김(OCP 위반)
//    ----------------------------------------------------------------------
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;


    //@Autowired
    // 생성자 주입을 하게되면, final을 사용할 수 있음.
    public OrderServiceImpl2(MemberRepository memberRepository, @MainAnnotationPolicy DiscountPolicy discountPolicy) {
        System.out.println("1. OrderServiceImpl.OrderServiceImpl");
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return  new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
