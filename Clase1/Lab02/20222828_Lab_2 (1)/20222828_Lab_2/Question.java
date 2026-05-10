import java.util.List;

abstract class Question implements Printable{
	protected String prompt;
	protected int code;
	protected List<String> options;

	//Constructor
	public Question(int code, String prompt, List<String> options){
		this.code = code;
		this.prompt = prompt;
		this.options = options;
	}

	public void setPrompt(String prompt){
		this.prompt = prompt;
	}

	public String getPrompt(){
		return this.prompt;
	}

	public void setCodPregunta(int codPregunta){
		this.code = codPregunta;
	}

	public int getCodPregunta(){
		return this.code;
	}

	public List<String> getOptions() { return options; }
}