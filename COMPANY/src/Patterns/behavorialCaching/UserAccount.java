package Patterns.behavorialCaching;

import lombok.*;

@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class UserAccount {
    private String userId;
    private String userName;
    private String additionalInfo;
}
