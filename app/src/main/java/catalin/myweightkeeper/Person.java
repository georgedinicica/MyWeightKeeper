package catalin.myweightkeeper;


import android.util.Log;

/**
 * Created by Catalin on 29/05/2017.
 */

public class Person {

    public final String TAG = "catalin.weightkeeper";
    int _id;
    String _name;
    int _age;
    private float _weight;

    public Person() {
    }

    public Person(String _name, int _age, float _weight) {
        this._name = _name;
        this._age = _age;
        this._weight = _weight;
    }

    public Person(int _id, String _name, int _age, float _weight) {
        this._id = _id;
        this._name = _name;
        this._age = _age;
        this._weight = _weight;
    }

    public int getID() {
        return _id;
    }

    public void setID(int _id) {
        this._id = _id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public int getAge() {
        return _age;
    }

    public void setAge(int _age) {
        this._age = _age;
    }

    public float getWeight() {
        return _weight;
    }

    public void setWeight(float _weight) {
        this._weight = _weight;
    }

    void logAPerson(Person p) {
        String logPerson = "name:" + p.getName() + "\nage:" + p.getAge() + "\nweight:" + p.getWeight();
        Log.d(TAG, logPerson);
    }
}
