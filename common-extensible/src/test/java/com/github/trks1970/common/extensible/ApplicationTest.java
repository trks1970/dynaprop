package com.github.trks1970.common.extensible;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApplicationTest {

  @Test
  void contextLoads() {
    Assertions.assertThat(this.getClass()).isEqualTo(ApplicationTest.class);
  }
}
