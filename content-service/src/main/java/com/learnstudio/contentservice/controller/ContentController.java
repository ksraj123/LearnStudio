package com.learnstudio.contentservice.controller;

import com.learnstudio.contentservice.enums.DevicePlatform;
import com.learnstudio.contentservice.pojo.reponse.ResourcePriceResponse;
import com.learnstudio.contentservice.pojo.reponse.ResourceShareResponse;
import com.learnstudio.contentservice.pojo.reponse.Response;
import com.learnstudio.contentservice.service.ContentService;
import com.learnstudio.contentservice.utils.Constants;
import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/content", consumes = "application/json", produces = "application/json")
@Api(value="Content controller")
public class ContentController extends AbstractController{

    private final ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @RequestMapping(value = "/{contentId}/share", method = RequestMethod.POST)
    @ApiOperation(value = "Share the content", response = ResourceShareResponse.class)
    @Timed
    public Response<?> share(@PathVariable(value = "contentId") Long contentId,
                             @RequestParam(value = "courseId") Long courseId,
                             @RequestParam(value = "moduleId", required = false) Long moduleId) throws Exception {
        ResourceShareResponse resourceShareResponse = contentService.share(contentId, courseId, moduleId);
        return getSuccessResponse(resourceShareResponse);
    }

    @RequestMapping(value = "/{id}/price", method = RequestMethod.GET)
    @ApiOperation(value = "Get content price", response = ResourcePriceResponse.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constants.HEADER_PLATFORM, value = "platform", paramType = "header", dataTypeClass = DevicePlatform.class, example = "ANDROID")})
    @Timed
    public Response<?> getContentPrice(@RequestHeader(value = Constants.HEADER_PLATFORM) DevicePlatform platform,
                                       @PathVariable(value = "id") Long contentId,
                                       @RequestParam(value = "courseId") Long courseId,
                                       @RequestParam(value = "moduleId") Long moduleId,
                                       @RequestParam(value = "currencyCode") String currencyCode) {
        ResourcePriceResponse resourcePriceResponse = contentService.getContentPrice(platform, courseId, moduleId, contentId, currencyCode);
        return getSuccessResponse(resourcePriceResponse);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get contents by ids.", response = ContentView.class, responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constants.HEADER_PLATFORM, value = "platform", paramType = "header", dataTypeClass = DevicePlatform.class, example = "ANDROID")})
    @Timed
    public Response<?> getContentsByIds(@RequestHeader(value = Constants.HEADER_PLATFORM) DevicePlatform platform,
                                        @RequestHeader(value = Constants.HEADER_USER_ID, required = false) Long userId,
                                        @RequestParam(value = "ids", required = false) List<Long> idList,
                                        @RequestParam(value = "currencyCode", required = false, defaultValue = "INR") String currencyCode,
                                        @RequestParam(value = "getUserMeta", required = false, defaultValue = "false") boolean getUserMeta) {
        List<ContentView> contentViewList = contentService.getContentByIdIn(platform, userId, idList, currencyCode, getUserMeta);
        return getSuccessResponse(contentViewList);
    }
}
