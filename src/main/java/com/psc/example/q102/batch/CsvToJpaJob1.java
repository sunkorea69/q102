//package com.psc.example.q102.batch;
//
//import com.psc.example.q102.domain.Dept;
//import com.psc.example.q102.dto.TwoDto;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.persistence.EntityManagerFactory;
//
//@Slf4j
//@RequiredArgsConstructor
//@Configuration
//public class CsvToJpaJob1 {
//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory;
//    private final EntityManagerFactory entityManagerFactory;
//
//    private final int chunkSize = 10;
//
//    @Bean
//    public Job csvToJpaJob1_bathBuild() throws Exception{
//        return jobBuilderFactory.get("csvToJpaJob1")
//                .start(csvToJpaJob1_batchStep1())
//                .build();
//    }
//
//    @Bean
//    public Step csvToJpaJob1_batchStep1() throws Exception {
//        return stepBuilderFactory.get("csvToJpaJob1_batchStep1")
//                .<TwoDto, Dept>chunk(chunkSize)
//                .reader(csvToJpaJob1_fileReader())
//                .processor(csvToJpaJob1_processor())
//                .writer(csvToJpaJob1_dbItemWriter())
//                .build();
//    }
//
//    @Bean
//
//}
