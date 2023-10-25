package work.keepcode.configdal.datasource.nacos;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.client.config.NacosConfigService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import work.keepcode.configdal.datasource.ConfigdalDatasource;
import work.keepcode.configdal.support.ConfigdalExceptionUtils;

@RequiredArgsConstructor
@Slf4j
public class ConfigdalNacosDatasource implements ConfigdalDatasource {

    private final NacosConfigService nacosConfigService;

    @Override
    public String getContent(String dataId, String group) {
        String config;
        try {
            config = nacosConfigService.getConfig(dataId, group, 1000);
        } catch (NacosException e) {
            throw ConfigdalExceptionUtils.wrapException(e);
        }
        return config;
    }


}