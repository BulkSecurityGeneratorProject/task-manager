package eu.marcinszewczyk.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Tag.
 */
@Entity
@Table(name = "tag")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Tag implements Serializable, UserAware {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "jhi_user")
    private Long user;

    @ManyToOne
    @JsonIgnoreProperties("tags")
    private Task task;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Tag name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUser() {
        return user;
    }

    public Tag user(Long user) {
        this.user = user;
        return this;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Task getTask() {
        return task;
    }

    public Tag task(Task task) {
        this.task = task;
        return this;
    }

    public void setTask(Task task) {
        this.task = task;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tag tag = (Tag) o;
        if (tag.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tag.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Tag{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", user=" + getUser() +
            "}";
    }
}
