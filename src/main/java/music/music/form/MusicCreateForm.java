package music.music.form;

//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MusicCreateForm {
//    @Size(min = 1, max = 127)
    @NotBlank
    private String musicName;
    @NotBlank
    private String artistName;
    @NotBlank
    private String albumName;
    @NotBlank
    private int good;

}
