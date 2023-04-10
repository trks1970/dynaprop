package com.github.trks1970.common.extensible.domain.service;

import com.github.trks1970.common.extensible.TestJPAConfig;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {TestJPAConfig.class})
public class ExtensibleTypeServiceTest {}
