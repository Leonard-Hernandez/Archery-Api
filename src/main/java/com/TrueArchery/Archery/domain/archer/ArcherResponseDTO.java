package com.TrueArchery.Archery.domain.archer;



public record ArcherResponseDTO(Long id,String idDocument, String name, String category , Boolean active) {

    public ArcherResponseDTO(Archer archer) {

        this(archer.getId(), archer.getIdDocument(), archer.getName(), archer.getCategory().toString(), archer.isActive());

    }
}
