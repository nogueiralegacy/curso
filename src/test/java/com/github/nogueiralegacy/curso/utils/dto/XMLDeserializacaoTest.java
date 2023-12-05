package com.github.nogueiralegacy.curso.utils.dto;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class XMLDeserializacaoTest {
    String xml = "<universidade>\n" +
            "\t<curso>\n" +
            "\t\t<iden>26823</iden>\n" +
            "\t\t<ano>1989</ano>\n" +
            "\t\t<nome>ENGENHARIA DE COMPUTAÇÃO</nome>\n" +
            "\t\t<disciplina>LINGUAGENS XDBQHPDONOAYTXO</disciplina>\n" +
            "\t\t<ch>124</ch>\n" +
            "\t</curso>\n" +
            "\t<curso>\n" +
            "\t\t<iden>33970</iden>\n" +
            "\t\t<ano>1966</ano>\n" +
            "\t\t<nome>ENGENHARIA DE COMPUTAÇÃO</nome>\n" +
            "\t\t<disciplina>FILOSOFIA, JMSLWSOWMKDTWPY</disciplina>\n" +
            "\t\t<ch>109</ch>\n" +
            "\t</curso>\n" +
            "\t<curso>\n" +
            "\t\t<iden>12275</iden>\n" +
            "\t\t<ano>2011</ano>\n" +
            "\t\t<nome>ENGENHARIA DE COMPUTAÇÃO</nome>\n" +
            "\t\t<disciplina>TRABALHO NVDLZETAZWXJNXX</disciplina>\n" +
            "\t\t<ch>72</ch>\n" +
            "\t</curso>\n" +
            "</universidade>";


    @Test
    void deserializacaoTest() {
        XmlMapper xmlMapper = new XmlMapper();
        UniversidadeDTO universidadeDTO = null;

        try {
            universidadeDTO = xmlMapper.readValue(xml, UniversidadeDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertNotNull(universidadeDTO);
        assertEquals(universidadeDTO.getCursos().size(), 3);
        assertEquals(universidadeDTO.getCursos().get(0).getNome(), "ENGENHARIA DE COMPUTAÇÃO");
        assertEquals(universidadeDTO.getCursos().get(0).getDisciplinaNome(), "LINGUAGENS XDBQHPDONOAYTXO");
        assertEquals(universidadeDTO.getCursos().get(2).getCh(), 72);
    }
}
