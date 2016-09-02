## eSDK\_EC\_SDK\_Java  ##
华为企业云通信平台，可为企业提供一站式的融合的通信平台，包括高清音视频会议、Web 会议、协作、企业总机、IP 语音等丰富的业务，可适配不同企业不同的场景应用。 通过开放这些通信能力，与企业业务系统融合，既提升了企业内部的生产及办公效率，又能更高效的与企业的客户和伙伴协同，助力企业实现商业创新和商业成功。

华为融合通信**eSDK\_EC\_SDK\_Java**提供SOAP接口和Java本地化接口，为您提供即时消息、号码管理、账号管理、部门管理、会议管理、通讯录查询、CTC会议等业务集成能力。

## 版本更新 ##
eSDK EC最新版本v1.5.70

## 开发环境 ##

- 操作系统： Windows7专业版
- JDK 1.8或以上版本
- Eclipse for Java EE：Eclipse 4.4.2或以上版本

## 文件指引 ##

- src文件夹：eSDK\_EC\_SDK\_Java源码
- sample文件夹：eSDK EC SDK的代码样例
- doc：eSDK EC SDK的接口参考、开发指南
- third-party:eSDK EC SDK中使用的第三方库


## 入门指导 ##
编译SOAP工程：

- 把src/Platform目录下的六个工程导入eclipse，修正其Java Build Path中引用jar包的路径。
- 把src/SOAP目录下的七个工程导入eclipse之后，修正其Java Build Path中引用jar包的路径。
- 编译运行：编译工作空间中的这13个工程，将esdk_platform_web添加到在eclipse上配置的Server中，并在该Server的Launch configuration中添加其余12个工程及其引用的类库，保存配置并运行Server。
- 详细的开发指南请参考doc中的开发指南

编译Java Native及Sample Code：

- 将这些工程导入eclipse，直接编译运行即可。

###查询个人详情###
体验华为UC系统的能力，以下代码演示如何查询个人详情

    Step1：填充配置文件esdk_ec_config.properties
    rest.url = http://10.135.43.69:8086
    username=esdk_user
    password=Huawei@123

    Step2：编写代码
    //get userProfileServiceEx Instance
    UserProfileServiceEx userProfileServiceEx = ServiceFactoryEx.getService(UserProfileServiceEx.class);
    //ucAccount
    String ucAccount = "user001";
    //execute queryStaffInfo method
    RestResponse<PersonInfo> res = userProfileServiceEx.queryStaffInfo(ucAccount);


## 获取帮助 ##

在开发过程中，您有任何问题均可以至[DevCenter](https://devcenter.huawei.com)中提单跟踪。也可以在[华为开发者社区](http://bbs.csdn.net/forums/hwucdeveloper)中查找或提问。另外，华为技术支持热线电话：400-822-9999（转二次开发）