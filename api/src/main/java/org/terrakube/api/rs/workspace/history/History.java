package org.terrakube.api.rs.workspace.history;

import com.yahoo.elide.annotation.CreatePermission;
import com.yahoo.elide.annotation.DeletePermission;
import com.yahoo.elide.annotation.Include;
import com.yahoo.elide.annotation.UpdatePermission;
import lombok.Getter;
import lombok.Setter;
import org.terrakube.api.plugin.security.audit.GenericAuditFields;
import org.terrakube.api.rs.workspace.Workspace;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Include(rootLevel = false)
@CreatePermission(expression = "user is a super service")
@UpdatePermission(expression = "user is a super service")
@DeletePermission(expression = "user is a super service")
@Getter
@Setter
@Entity
public class History extends GenericAuditFields {

    @Id
    @Type(type="uuid-char")
    @GeneratedValue
    private UUID id;

    @Column(name = "job_reference")
    private String jobReference;

    @Column(name = "output")
    private String output;

    @ManyToOne
    private Workspace workspace;

}
