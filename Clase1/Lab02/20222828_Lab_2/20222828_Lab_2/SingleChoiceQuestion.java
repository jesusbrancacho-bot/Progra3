import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class SingleChoiceQuestion extends Question{
	int correctOption;
	
	public SingleChoiceQuestion( int code, String prompt,List<String> options, int correctOption){
		super(code,prompt,options);
		this.correctOption = correctOption;
	}

	public void setRespuesta(int respuesta){
		this.correctOption = respuesta;
	}
	
	public int getRespuesta(){
		return this.correctOption;
	}

	@Override
	public String devolverDatos() {
		String datos = "Pregunta " + code + ": " + prompt +"\n";
		for (int i=0; i<options.size();i++){
			datos += (i + 1) + ") " + options.get(i) + "\n";
		}

		datos += "Respuesta correcta: " + correctOption + "\n";
		return datos;
	}
}