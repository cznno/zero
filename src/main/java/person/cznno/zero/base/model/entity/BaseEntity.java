package person.cznno.zero.base.model.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by cznno
 * Date: 17-12-28
 */
@Data
public class BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Transient
    private Integer page = 1;

    @Transient
    private Integer rows = 10;
}