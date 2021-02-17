package com.mobicare.backendplenohigorbraga.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobicare.backendplenohigorbraga.domain.Colaborador;
import com.mobicare.backendplenohigorbraga.domain.Setor;
import com.mobicare.backendplenohigorbraga.repositories.ColaboradorRepository;
import com.mobicare.backendplenohigorbraga.repositories.SetorRepository;

@Service
public class DBService {



	@Autowired
	private ColaboradorRepository colabRepo;
	
	@Autowired 
	SetorRepository setorRepo;

	public void instantiateTestDatabase() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm");
		
		Setor setor1 = new Setor(null, "Atendimento ao Usuário"); 
		Setor setor2 = new Setor(null, "Qualidade e Testes");
		Setor setor3 = new Setor(null, "Desenvolvimento");
		Setor setor4 = new Setor(null, "Direção");
		Setor setor5 = new Setor(null, "Plataforma");		

		Colaborador colab1 = new Colaborador(null, "40551753021", "Higor Braga", "21971926933", "emaildeteste@gmail.com", sdf.parse("12/10/1993 21:55"), setor3);
		Colaborador colab2 = new Colaborador(null, "73532841029", "Fulano de tal", "21971926933", "emaildeteste@gmail.com", sdf.parse("05/02/1983 21:55"), setor1);
		Colaborador colab3 = new Colaborador(null, "36926270090", "Ciclano de teste", "21971926933", "emaildeteste@gmail.com", sdf.parse("05/02/1995 21:55"), setor3);
		Colaborador colab4 = new Colaborador(null, "46126671074", "Yuri Braga", "21971926933", "emaildeteste@gmail.com", sdf.parse("05/02/1997 21:55"), setor3);
		Colaborador colab5 = new Colaborador(null, "87036385022", "Luan Braga", "21971926933", "emaildeteste@gmail.com", sdf.parse("05/02/1991 21:55" ), setor1);
		Colaborador colab6 = new Colaborador(null, "99081081071", "Cecilia Braga", "21971926933", "emaildeteste@gmail.com", sdf.parse("05/02/1991 21:55"), setor2);
		Colaborador colab7 = new Colaborador(null, "94739100029", "Lenita Braga", "21971926933", "emaildeteste@gmail.com", sdf.parse("05/02/1978 21:55" ), setor2);
		Colaborador colab8 = new Colaborador(null, "72845480024", "Francisco Antonio", "21971926933", "emaildeteste@gmail.com", sdf.parse("05/02/1975 21:55"), setor4);
		Colaborador colab9 = new Colaborador(null, "83872073060", "Lorena de paula", "21971926933", "emaildeteste@gmail.com", sdf.parse("05/02/2002 21:55" ), setor4);
		Colaborador colab10 = new Colaborador(null, "35589046050", "Lucas Cassiano", "21971926933", "emaildeteste@gmail.com", sdf.parse("05/02/2004 21:55" ), setor4);
		Colaborador colab11 = new Colaborador(null, "16437666005", "Arthur de paula", "21971926933", "emaildeteste@gmail.com", sdf.parse("05/02/2002 21:55" ), setor5);
		Colaborador colab12 = new Colaborador(null, "64551251003", "Roberto da silva", "21971926933", "emaildeteste@gmail.com", sdf.parse("05/02/1955 21:55" ), setor2);
		Colaborador colab13 = new Colaborador(null, "42782186051", "Manuela Siqueira", "21971926933", "emaildeteste@gmail.com", sdf.parse("05/02/1991 21:55" ), setor3);
		Colaborador colab14 = new Colaborador(null, "82011244056", "Alan negreiros", "21971926933", "emaildeteste@gmail.com", sdf.parse("05/02/1990 21:55" ), setor3);
		Colaborador colab15 = new Colaborador(null, "97608174030", "Marcos Paulo", "21971926933", "emaildeteste@gmail.com", sdf.parse("05/02/1982 21:55" ), setor3);

		setorRepo.saveAll(Arrays.asList(setor1,setor2,setor3,setor4,setor5));

		colabRepo.saveAll(Arrays.asList(
				colab1,colab2,colab3,colab4,colab5,
				colab6,colab7,colab8,colab9,colab10,
				colab11,colab12,colab13,colab14,colab15));
		
	}

}
