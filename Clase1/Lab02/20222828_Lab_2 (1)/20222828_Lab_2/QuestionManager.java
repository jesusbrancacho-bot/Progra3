import java.util.ArrayList;
import java.util.List;
import java.util.Random;
class QuestionManager {

	private List<Question> questions;
	public QuestionManager(){
		this.questions = new ArrayList<>();
	}

	public void add(Question pregunta){
		questions.add(pregunta);
	}


	public List<Question>  selectRandomN(int n){
		//se crea una copia de la lista questions
		List<Question> copia = new ArrayList<>(questions);
		//numero random
		Random rand = new Random();
		//lista de pregunta seleccionadas
		List<Question> seleccionadas = new ArrayList<>();
		for(int i=0;i<n && copia.size()>0;i++){
			int index = rand.nextInt(copia.size());
			seleccionadas.add(copia.get(index));
			//Elimina esa pregunta de la copia para que no vuelva a salir la misma
			copia.remove(index);
		}

		return seleccionadas;
	}
}