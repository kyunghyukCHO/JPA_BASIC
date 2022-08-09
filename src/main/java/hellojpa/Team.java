package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    //양방향 연관관계
    //객체의 양방향 연관관계는 결국 두개의 단방향으로 볼 수 있습니다.
    //그렇다면 DB에 TEAM_ID 를 관리하기 위해서 Member 그리고 Team 중에 어떤 객체를 참조해야 하는가에 대한 이슈가 있습니다
    //결론은 둘 중 하나를 선택해야 하는데.. 이것이 연관관계의 주인 개념 입니다!
    //외래키가 있는 곳이 주인이 되고 주인 객체가 DB에 반영합니다
    @OneToMany(mappedBy = "team") // team 은 Member 의 객체 변수 명과 동일
    //@JoinColumn(name = "TEAM_ID") // 일대다 연관관계 매핑시 TEAM 이 주인을 가져가는 경우 ..! BUT ! 권장사항 X
    //이유는.. member 의 외래키를 수정하기 위한 추가적인 쿼리가 발생됩니다 -> 성능문제
    private List<Member> members = new ArrayList<>();

    public void addMember(Member member) {
        member.setTeam(this);
        members.add(member);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
