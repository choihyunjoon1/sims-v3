package co.spoonradio.sims.service.common

import co.spoonradio.sims.dto.response.common.Download
import co.spoonradio.sims.dto.response.common.ExtraDataEntity
import co.spoonradio.sims.dto.response.common.SimsResponseEntity
import co.spoonradio.sims.dto.response.init.Menu.MainMenu

interface CommonService {
    fun getInit(): SimsResponseEntity<List<MainMenu>, ExtraDataEntity>
    fun download(key:String): Download
}
