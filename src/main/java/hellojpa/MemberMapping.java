package hellojpa;

import javax.persistence.*;

@Entity
//@Table(name="MBR")
//@Table(uniqueConstraints = )
@SequenceGenerator(
        name = "member_seq_generator",
        sequenceName = "member_seq",
        initialValue = 1, allocationSize = 50)
        // 네트워크 혼잡을 최적화 시키기 위해 미리 50개의 사이즈만 땡겨옵니다!
public class MemberMapping {

    //////////////////// 기본 키 매핑 //////////////////////
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
    // SEQUENCE 의 경우 String 이 아닌 Long or Integer ..
    // Table 마다 시퀀스를 따로 관리하고자 한다면 SequenceGenerator 을 사용하면 됩니다.
    private Long id;

    @Column(name = "name", nullable = false)
    private String username;

    public MemberMapping() { }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }


    //////////////////// 매핑 기본 //////////////////////
//    @Id
//    private Long id;
//    //  @Column(unique = true, length = 10)
//    @Column(name = "name", nullable = false)
//    private String username;
//    private Integer age;
//    @Enumerated(EnumType.STRING) // 디폴트로 쓰지 말것!! -> 디폴트로 사용할 시 순서가 부여됨
//    private RoleType roleType;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//    private LocalDate testLocalDate;
//    private LocalDateTime testLocalDateTime;
//    @Lob
//    private String description;
//    @Transient
//    // 테이블에 올리지 않고 메모리에서만 사용함
//    private int temp;
//    public Member() {
//    }
}
