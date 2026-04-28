package br.com.siger.siger_api.model;

import br.com.siger.siger_api.enums.EnumTaskStatus;
import br.com.siger.siger_api.global.model.GenericBaseModel;
import br.com.siger.siger_api.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "tb_task", schema = "bd_siger")
public class Task extends GenericBaseModel<Long> {

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "title")
    private String title;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description")
    private String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EnumTaskStatus status;

    @NotNull
    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @NotNull
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @NotNull
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private User assignee;

    @ManyToOne
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;
}
