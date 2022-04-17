package com.psc.example.q102.batch;

import com.psc.example.q102.dto.TwoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


@Slf4j
@RequiredArgsConstructor
@Configuration
public class FixedJob2 {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final int chunkSize = 5;

    @Bean
    public Job fixedJob2_batchBuild() {
        return jobBuilderFactory.get("fixedJob2")
                .start(fixedJob2_batchStep1())
                .build();
    }

    @Bean
    public Step fixedJob2_batchStep1() {
        return stepBuilderFactory.get("fixedJob2_batchStep1")
                .<TwoDto, TwoDto>chunk(chunkSize)
                .reader(fixedJob2_fileReader())
//                .writer(csvJob2_FileWriter(new FileSystemResource("output/csvJob2_input.csv")))
                .writer(twoDto -> twoDto.stream().forEach(twoDto2 -> {
                    System.out.println(twoDto2.getTwo());
                }))
                .build();
    }

    @Bean
    public FlatFileItemReader<TwoDto> fixedJob2_fileReader() {
        FlatFileItemReader<TwoDto> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(new ClassPathResource("sample/fixedjob1_input.txt"));
        flatFileItemReader.setLinesToSkip(1);
        DefaultLineMapper<TwoDto> defaultLineMapper = new DefaultLineMapper<>();
        FixedLengthTokenizer fixedLengthTokenizer = new FixedLengthTokenizer();

        fixedLengthTokenizer.setNames("one", "two");
        fixedLengthTokenizer.setColumns(new Range(1,5), new Range(6,10));
        BeanWrapperFieldSetMapper<TwoDto> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
        beanWrapperFieldSetMapper.setTargetType(TwoDto.class);

        defaultLineMapper.setLineTokenizer(fixedLengthTokenizer);
        defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);

        flatFileItemReader.setLineMapper(defaultLineMapper);
        return flatFileItemReader;
    }

//    @Bean
//    public FlatFileItemWriter<TwoDto> csvJob2_FileWriter(Resource resource) {
//        BeanWrapperFieldExtractor<TwoDto> beanWrapperFieldExtractor = new BeanWrapperFieldExtractor<>();
//        beanWrapperFieldExtractor.setNames(new String[]{"one", "two"});
//        beanWrapperFieldExtractor.afterPropertiesSet();
//        DelimitedLineAggregator<TwoDto> dtoDelimitedLineAggregator = new DelimitedLineAggregator<>();
//        dtoDelimitedLineAggregator.setDelimiter("@");
//        dtoDelimitedLineAggregator.setFieldExtractor(beanWrapperFieldExtractor);
//        return new FlatFileItemWriterBuilder<TwoDto>().name("csvJob2_FileWriter")
//                .resource(resource)
//                .lineAggregator(dtoDelimitedLineAggregator)
//                .build();
//    }


}
