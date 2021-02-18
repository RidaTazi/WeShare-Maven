package DCL;

import java.util.Array;
import java.util.ArrayList;
import DCL.Publication;
import DCL.Don;

public class Association extends User {
	private String _nom_Assoc;
	private String _code_Assoc;
	private String _desc_Assoc;
	private String _logo_Assoc;
	private String _addr_Assoc;
	public Array<Publication> _ajouter = new ArrayList<Publication>();
	public Array<Don> _recevoir = new ArrayList<Don>();

	public Association() {
		throw new UnsupportedOperationException();
	}

	public Association(Object aParameter) {
		throw new UnsupportedOperationException();
	}

	public String getNom_Assoc() {
		return this._nom_Assoc;
	}

	public void setNom_Assoc(String aNom_Assoc) {
		this._nom_Assoc = aNom_Assoc;
	}

	public String getCode_Assoc() {
		return this._code_Assoc;
	}

	public void setCode_Assoc(String aCode_Assoc) {
		this._code_Assoc = aCode_Assoc;
	}

	public String getDesc_Assoc() {
		return this._desc_Assoc;
	}

	public void setDesc_Assoc(String aDesc_Assoc) {
		this._desc_Assoc = aDesc_Assoc;
	}

	public String getLogo_Assoc() {
		return this._logo_Assoc;
	}

	public void setLogo_Assoc(String aLogo_Assoc) {
		this._logo_Assoc = aLogo_Assoc;
	}

	public String getAddr_Assoc() {
		return this._addr_Assoc;
	}

	public void setAddr_Assoc(String aAddr_Assoc) {
		this._addr_Assoc = aAddr_Assoc;
	}

	public static void createAssociation() {
		throw new UnsupportedOperationException();
	}

	public static Association getAssociation() {
		throw new UnsupportedOperationException();
	}

	public static Array<Association> filterAssociation() {
		throw new UnsupportedOperationException();
	}

	public static void updateAssociation() {
		throw new UnsupportedOperationException();
	}

	public static void deleteAssociation() {
		throw new UnsupportedOperationException();
	}
}