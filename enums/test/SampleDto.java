package test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import simpleenum.DayEnum;
import simpleenum.GenderEnum;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SampleDto {
	String name;
	DayEnum day;
	GenderEnum gender;
}
