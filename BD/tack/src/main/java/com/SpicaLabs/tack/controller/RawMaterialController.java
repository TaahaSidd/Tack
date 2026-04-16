package com.SpicaLabs.tack.controller;

import com.SpicaLabs.tack.dto.request.RawMaterialReqDto;
import com.SpicaLabs.tack.dto.response.RawMaterialRespDto;
import com.SpicaLabs.tack.services.RawMaterialService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Tack/rawMaterials")
@RequiredArgsConstructor
public class RawMaterialController {

    private final RawMaterialService rawMaterialService;

    @PostMapping("/add")
    public ResponseEntity<RawMaterialRespDto> addRawMaterial(@Valid @RequestBody RawMaterialReqDto req) {
        return ResponseEntity.ok(rawMaterialService.addRawMaterial(req));
    }

    @GetMapping("/all")
    public ResponseEntity<List<RawMaterialRespDto>> getAllRawMaterials() {
        return ResponseEntity.ok(rawMaterialService.getAllRawMaterials());
    }
}
