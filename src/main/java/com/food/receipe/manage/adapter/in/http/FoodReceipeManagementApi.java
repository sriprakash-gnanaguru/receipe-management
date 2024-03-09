package com.food.receipe.manage.adapter.in.http;

import com.food.receipe.manage.adapter.out.http.OutputResponse;
import com.food.receipe.manage.common.BusinessException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/manage-receipe")
public interface FoodReceipeManagementApi {

    @Operation(summary = "This Service is used to add recipe with given detail in the database.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Receipe added Successfully in the database.",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = OutputResponse.class))}),
            @ApiResponse(
                    responseCode = "400",
                    description = "1) If required request body is missing.<br/>" +
                            "2) If JSON Content is missing.<br/>" +
                            "3) If interactive process  is missing."),
            @ApiResponse(
                    responseCode = "500",
                    description = "Exception while connecting the database"),
            @ApiResponse(
                    responseCode = "503",
                    description = "Unavailability of the Service")
    })
    @PostMapping("/addReceipe")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    OutputResponse addReceipe( @NonNull @RequestBody InputRequest request) throws BusinessException;

    @PostMapping("/deleteReceipe")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    OutputResponse deleteReceipe(@RequestParam(value = "ReceipeId") String receipeId) throws BusinessException;


}
