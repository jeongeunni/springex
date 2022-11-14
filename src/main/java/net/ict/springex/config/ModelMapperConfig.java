package net.ict.springex.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class ModelMapperConfig {
    @Bean //빈이기 때문에 modelmapper스프링 등록 (root-context.xml 에 등록)
    public ModelMapper getMapper() {
        ModelMapper modelMapper = new ModelMapper(); //왜 필요? 프로젝트에서 vo를 dto로 변환하거나 dto를 vo로 변환하기위해
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
