package fr.eni.qcm.beans;

public enum CodeProfil {


        CANDIDAT_LIBRE(1), STAGIAIRE(2), RESPONSABLE(3), FORMATEUR(4), ADMIN(5), CELLULE_RECRUTEMENT(6);

        public int codeProfil;

        public int getCode() {
            return codeProfil;
        }

        private CodeProfil(int code) {

            this.codeProfil = code;
        }
}