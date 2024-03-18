package hello.itemservice.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

import static org.assertj.core.api.Assertions.*;

public class MessageCodesResolverTest {

    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();


    @Test
    void messageCodesResolverObject() {
        String[] strings = codesResolver.resolveMessageCodes("required", "item");
        for (String s : strings ) {
            System.out.println("s = " + s);
        }
        assertThat(strings).containsExactly("required.item", "required");
    }
    
    @Test
    void messageCodesResolverField() {
        //bindingResult.rejectedValue()를 실행하면 하단의 코드가 진행이 됨
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item", "itemName", String.class);
        for(String s : messageCodes) {
            System.out.println("s = " + s);
        }
        assertThat(messageCodes).containsExactly(
                "required.item.itemName"
                , "required.itemName"
                , "required.java.lang.String"
                , "required"
                );
    }
}
