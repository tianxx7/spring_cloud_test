package txx.cloud.eurekaprovider.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "txx.cloud.eurekaprovider.bean.UserDto", description = "用户信息")
public class UserDto {

	@ApiModelProperty(value="ID")
	private String id;
	
	@ApiModelProperty(value="名称")
	private String name;
	
}
