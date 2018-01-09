package person.cznno.zero.base.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "person.cznno.zero.*.dao")
//@ImportResource("classpath:config/spring-mybatis.xml")
public class DataSourceConfig {

    //在yml里配置

//    static final String MAPPER_LOCATION = "classpath*:**/mappers/*.xml";
//
//    @Value("${spring.datasource.url}")
//    private String url;
//    @Value("${spring.datasource.username}")
//    private String username;
//    @Value("${spring.datasource.password}")
//    private String password;
//    @Value("${spring.datasource.driver-class-name}")
//    private String driver;
//
//    @Bean(name = "dataSource")
//    public DriverManagerDataSource dataSource() {
//        //DruidDataSource dataSource = new DruidDataSource();//alibaba druid datasource
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(driver);
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        return dataSource;
//    }
//    @Bean(name = "transactionManager")
//    public DataSourceTransactionManager transactionManager() {
//        return new DataSourceTransactionManager(dataSource());
//    }
//
//    @Bean(name = "sqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource)
//            throws Exception {
//        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources(DataSourceConfig.MAPPER_LOCATION));
//        return sessionFactory.getObject();
//    }
}