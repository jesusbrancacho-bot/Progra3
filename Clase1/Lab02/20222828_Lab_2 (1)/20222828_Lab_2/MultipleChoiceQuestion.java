import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class MultipleChoiceQuestion extends Question{

	private List<Integer> correctOptions;

	public MultipleChoiceQuestion(int code, String prompt, List<String> options, List<Number> respuestas){
		super(code,prompt,options);
		this.correctOptions = new ArrayList<>();
	}



	public void setRespuestas(List<Integer>respuestas){
		this.correctOptions = new ArrayList<>(respuestas);
	}

	public List<Integer>getRespuestas(){
		return this.correctOptions;
	}


	@Override
	public String devolverDatos() {
		String datos = "Pregunta " + code + ": " + prompt + "\n";
		for (int i = 0; i < options.size(); i++) {
			datos += (i + 1) + ") " + options.get(i) + "\n";
		}
		datos += "Respuestas correctas: " + correctOptions + "\n";
		return datos;
	}
}