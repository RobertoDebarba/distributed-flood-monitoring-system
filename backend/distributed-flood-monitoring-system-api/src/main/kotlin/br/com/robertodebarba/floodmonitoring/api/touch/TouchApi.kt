package br.com.robertodebarba.floodmonitoring.api.touch

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController

class TouchApi {

    @Autowired
    lateinit var touchService: TouchService

    @CrossOrigin
    @RequestMapping("touch", method = arrayOf(RequestMethod.POST))
    fun postTouchMessage(@RequestBody touchDTO: TouchDTO) {
        touchService.postTouch(touchDTO)
    }
}