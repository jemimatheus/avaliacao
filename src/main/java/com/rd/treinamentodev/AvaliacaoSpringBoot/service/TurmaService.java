package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.AlunoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.InstrutorDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.TurmaDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.AlunoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.InstrutorEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.TurmaEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.CursoRepository;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    public List<TurmaDTO> listar(){
        List<TurmaEntity> listEntity = turmaRepository.findAll();
        List<TurmaDTO> listDTO = new ArrayList<>();


        for(TurmaEntity turmaEntity : listEntity){

            TurmaDTO turmaDTO = new TurmaDTO();
            turmaDTO.setAlunos(turmaDTO.getAlunos());
            turmaDTO.setCurso(turmaDTO.getCurso());
            turmaDTO.setDtFim(turmaDTO.getDtFim());
            turmaDTO.setInstrutores(turmaDTO.getInstrutores());



            List<InstrutorEntity> instrutorEntities = turmaEntity.getInstrutores();

            List<InstrutorDTO> instrutorDTOList = new ArrayList<>();

            for(InstrutorEntity instrutorEntity : instrutorEntities){
                InstrutorDTO instrutorDTO = new InstrutorDTO();
                instrutorDTO.setNome(instrutorEntity.getNomeInstrutor());
                instrutorDTO.setValorHora(instrutorEntity.getValorHora());


                instrutorDTOList.add(instrutorDTO);
            }

            turmaDTO.setInstrutores(instrutorDTOList);

            listDTO.add(turmaDTO);
        }

        //TODO implementar a conversão da lista de objetos de TurmaEntity para TurmaDTO e retornar a listDTO preenchida




        return listDTO;
    }
}
