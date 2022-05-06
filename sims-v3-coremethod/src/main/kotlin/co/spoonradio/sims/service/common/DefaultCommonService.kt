package co.spoonradio.sims.service.common

import co.spoonradio.sims.dto.response.common.Download
import co.spoonradio.sims.dto.response.common.ExtraDataEntity
import co.spoonradio.sims.dto.response.common.SimsResponseEntity
import co.spoonradio.sims.dto.response.init.Menu.MainMenu
import co.spoonradio.sims.exception.GeneralException
import co.spoonradio.sims.repository.redis.StoreRepository
import co.spoonradio.sims.service.adminuser.AdminUserInfoManager
import org.springframework.stereotype.Service

/**
 * @author whale@spoonradio.co
 * @date   2021/12/11.
 * @Desc
 */
@Service
class DefaultCommonService(
    val storeRepository: StoreRepository
) : CommonService{
    override fun getInit(): SimsResponseEntity<List<MainMenu>, ExtraDataEntity> {
        println("AdminUserInfoManager >> ${AdminUserInfoManager.getUserInfo().userId}")
        TODO("Not yet implemented")
    }

    override fun download(key:String): Download {
        val url = storeRepository.get("DOWNLOAD:${key}")?: throw GeneralException("00026")
        return Download(
            valid = true,
            url= url
        )
    }
}