package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    // 연관관계 X
//    @Column(name = "TEAM_ID")
//    private Long teamId;

    // 다대일 단방향 연관관계
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    // 일대다 연관관계
//    private Team team

    // 일대다 양방향
//    @ManyToOne
//    @JoinColumn(name = "TEAM_ID", insertable = false, updatable = false)
//    private Team team;

    // 일대일 연관관계
    // --대상 테이블에 외래 키 단방향 정리--
    // 단방향 관계는 JPA 지원하지 않고 양방향 관계를 지원합니다

    // 외래키 위치에 대한 이슈..
    // Locker 가 Member 외래키를 가지고 있을 경우 나중에 한명의 member 가 여러개의 locker 를 쓸 수 있다고 변경될 시
    // 유니크 제약조건만 없애주면 쉽게 다대일 관계를 만들 수 있습니다. 하지만 그 반대의 경우도 가능합니다.
    // 결론적으로 어디에 외래키를 넣어야 하는것은 딜레마가 존재하지만 대체로 member 에 외래키를 가지고 있는것이 낫습니다.
    // 자세한것은 강의자료 주테이블 외래키 vs 대상테이블 외래키 참조!
//    @OneToOne
//    @JoinColumn(name = "LOCKER_ID")
//    private Locker locker;

    // 다대일 연관관계
    // 매우 편해보이지만 실무에서 절대 사용하지 않습니다.
    // 연결 테이블이 단순히 연결만 하고 끝나지 않습니다.
    // 주문시간, 수량 같은 데이터가 들어올 수 있습니다.
    // 해결책으로..
//    @ManyToMany
//    @JoinTable(name = "MEMBER_PRODUCT")
//    private List<Product> products = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this); // 양방향 연관관계 매핑 메소드
    }
}
