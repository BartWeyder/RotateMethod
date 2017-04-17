package hello;

/**
 * Created by Eugenij Kizim on 16-Apr-17.
 *
 * Finding solution of system of linear equations by rotating method.
 */
public class RotateMethod {


    private Double[][] mainMatrix;
    private Double[] bMatrix;
    private StringBuilder result;

    /**
     * Constructor of class.
     *
     * @param mainMatrix Main Matrix
     * @param bMatrix =Matrix
     */
    public RotateMethod (Double[][] mainMatrix, Double[] bMatrix) {
        this.mainMatrix = mainMatrix;
        this.bMatrix = bMatrix;
        this.result = new StringBuilder();
    }

    /**
     * Multiplies matrix on found Tmatrix.
     *
     * @param tMatrix Found Tmatrix.
     * @param main flag to choose what we multiplying: either Main Matrix or b(=) Matrix.
     */
    public void matrixMultiply(Double[][] tMatrix, boolean main) {
        if (main) {
            this.result.append("Множимо: <br> ");
            Double[][] tempMatrix = new Double[tMatrix.length][tMatrix.length];

            for (int i = 0; i < tempMatrix.length; i++) {
                for (int j = 0; j < tempMatrix.length; j++) {
                    tempMatrix[i][j] = 0d;
                }
            }

            for (int k = 0; k < tMatrix.length; k++) {
                //cleaning string (jvm will do all stuff)
                for (int i = 0; i < tMatrix.length; i++) {
                    StringBuilder tempString = new StringBuilder();

                    this.result.append("<b>a\'[");
                    this.result.append(k+1);
                    this.result.append("][");
                    this.result.append(i+1);
                    this.result.append("]</b> = ");

                    for (int j = 0; j < tMatrix.length; j++) {

                        this.result.append("t[");
                        this.result.append(k+1);
                        this.result.append("][");
                        this.result.append(j+1);
                        this.result.append("] * a[");
                        this.result.append(j+1);
                        this.result.append("][");
                        this.result.append(i+1);
                        this.result.append("]");

                        //form second string with digits in calculating
                        tempString.append(tMatrix[k][j]);
                        tempString.append(" * ");
                        tempString.append(this.mainMatrix[j][i]);

                        //we don't need "+" after last element
                        if (j != tMatrix.length - 1) {
                            this.result.append(" + ");
                            tempString.append(" + ");
                        }

                        tempMatrix[k][i] = tempMatrix[k][i] +  (tMatrix[k][j] * this.mainMatrix[j][i]);
                    }

                    //getting result
                    tempString.append(" = ");
                    tempString.append(tempMatrix[k][i]);

                    //finishing string of calculating
                    this.result.append(" = ");
                    this.result.append(tempString);
                    this.result.append(" <br> ");
                }
            }
            this.mainMatrix = tempMatrix;
        }
        else {
            Double[] bTempMatrix = new Double[this.bMatrix.length];
            for (int i = 0; i < this.bMatrix.length; i++) {
                bTempMatrix[i] = 0d;
            }

            for (int i =0; i < tMatrix.length; i++) {
                StringBuilder tempString = new StringBuilder();
                if (i == 0)
                    this.result.append("З правої сторони: <br> ");
                this.result.append("<b>b\'[");
                this.result.append(i+1);
                this.result.append("]</b> = ");
                for (int j = 0; j< tMatrix.length; j++) {
                    this.result.append("t[");
                    this.result.append(i+1);
                    this.result.append("][");
                    this.result.append(j+1);
                    this.result.append("] * b[");
                    this.result.append(j+1);
                    this.result.append("]");

                    tempString.append(tMatrix[i][j]);
                    tempString.append(" * ");
                    tempString.append(this.bMatrix[j]);

                    if (j != tMatrix.length - 1) {
                        this.result.append(" + ");
                        tempString.append(" + ");
                    }

                    bTempMatrix[i] = bTempMatrix[i] + (tMatrix[i][j] * this.bMatrix[j]);
                }
                tempString.append(" = ");
                tempString.append(bTempMatrix[i]);

                this.result.append(" = ");
                this.result.append(tempString);
                this.result.append(" <br> ");
            }
            this.bMatrix = bTempMatrix;
        }
    }

    /**
     * Getting TMatrix.
     * @param i i label of Matrix.
     * @param j j label of Matrix
     * @return generated TMatrix.
     */
    public Double[][] getTMatrix (int i, int j) {
        this.result.append("Підраховуємо матрицю <b>Т[");
        this.result.append(i+1);
        this.result.append("][");
        this.result.append(j+1);
        this.result.append("]</b>: <br> ");

        Double[][] tMatrix = new Double[this.mainMatrix.length][this.mainMatrix.length];

        this.result.append("<b>c</b> = a[");
        this.result.append(i+1);
        this.result.append("][");
        this.result.append(i+1);
        this.result.append("] / Sqrt(a[");
        this.result.append(i+1);
        this.result.append("][");
        this.result.append(i+1);
        this.result.append("]^2 + a[");
        this.result.append(j+1);
        this.result.append("][");
        this.result.append(i+1);
        this.result.append("]^2) = ");
        this.result.append(this.mainMatrix[i][i]);
        this.result.append(" / Sqrt((");
        this.result.append(this.mainMatrix[i][i]);
        this.result.append(")^2 + (");
        this.result.append(this.mainMatrix[j][i]);
        this.result.append(")^2)");

        Double c = this.mainMatrix[i][i] / Math.sqrt((this.mainMatrix[i][i] * this.mainMatrix[i][i]) +
                (this.mainMatrix[j][i] * this.mainMatrix[j][i]));

        this.result.append(" = ");
        this.result.append(c);
        this.result.append("<br>");

        this.result.append("<b>s</b> = a[");
        this.result.append(j+1);
        this.result.append("][");
        this.result.append(i+1);
        this.result.append("] / Sqrt(a[");
        this.result.append(i+1);
        this.result.append("][");
        this.result.append(i+1);
        this.result.append("]^2 + a[");
        this.result.append(j+1);
        this.result.append("][");
        this.result.append(i+1);
        this.result.append("]^2) = ");
        this.result.append(this.mainMatrix[j][i]);
        this.result.append(" / Sqrt((");
        this.result.append(this.mainMatrix[i][i]);
        this.result.append(")^2 + (");
        this.result.append(this.mainMatrix[j][i]);
        this.result.append(")^2)");

        Double s = this.mainMatrix[j][i] / Math.sqrt((this.mainMatrix[i][i] * this.mainMatrix[i][i]) +
                (this.mainMatrix[j][i] * this.mainMatrix[j][i]));

        this.result.append(" = ");
        this.result.append(s);
        this.result.append("<br>");

        //filling array with 0
        for (int l = 0; l < tMatrix.length; l++) {
            for (int k = 0; k < tMatrix.length; k++) {
                tMatrix[l][k] = 0d;
            }
        }
        //filling diagonal
        for (int k = 0; k < tMatrix.length; k++) {
            if ((k == i) || (k == j))
                tMatrix[k][k] = c;
            else
                tMatrix[k][k] = 1d;
        }

        tMatrix[i][j] = s;
        tMatrix[j][i] = (-1) * s;

        return tMatrix;
    }

    /**
     * Generates table tag with simple matrix.
     * @param matrix Matrix that will be putted in table tag.
     * @return Generated string with tags.
     */
    public StringBuilder matrixView (Double[] matrix) {
        StringBuilder tempString = new StringBuilder("<table>");
        for (int i = 0; i < matrix.length; i++) {
            tempString.append("<tr><td>");
            tempString.append(matrix[i]);
            tempString.append("</td></tr>");
        }
        tempString.append("</table>");
        return tempString;
    }

    /**
     * Generates table tag with 2D matrix.
     * @param matrix Matrix that will be putted in table tag.
     * @return Generated string with tags.
     */
    public StringBuilder matrixView (Double[][] matrix) {
        StringBuilder tempString = new StringBuilder("<table>");
        for (int i = 0; i < matrix.length; i++) {
            tempString.append("<tr>");
            for (int j = 0; j < matrix.length; j++) {
                tempString.append("<td>");
                tempString.append(matrix[i][j]);
                tempString.append("</td>");
            }
            tempString.append("</tr>");
        }
        tempString.append("</table>");
        return tempString;
    }

    /**
     * Generates table tag of matrix multiply view.
     * @param tMatrix TMatrix that multiplies left and right part.
     * @param i i of TMAtrix.
     * @param j j of TMAtrix.
     * @return Generated string with table tags.
     */
    public StringBuilder generateMatrixMultiplyView(Double[][] tMatrix, int i, int j) {
        StringBuilder string = new StringBuilder("Множимо матрицю T[");
        string.append(i+1);
        string.append("][");
        string.append(j+1);
        string.append("] зліва на головну матрицю та вектор b: <br>");
        string.append("<table class=\"table-box\"><tr><td>");
        string.append(this.matrixView(tMatrix));
        string.append("</td><td style = \"border: none;\"> * </td><td>");
        string.append(this.matrixView(this.mainMatrix));
        string.append("</td><td style = \"border: none;\"> = </td><td>");
        string.append(this.matrixView(tMatrix));
        string.append("</td><td style = \"border: none;\"> * </td><td>");
        string.append(this.matrixView(this.bMatrix));
        string.append("</td></tr></table> <br>");
        return string;
    }

    /**
     * Makes Triangle Matrix from Main Matrix.
     */
    public void getTriangleMatrix() {
        Double[][] tMatrix;
        this.result.append("Починаємо з пошуку матриці Т: <br>");
        for (int i = 0; i < this.mainMatrix.length; i++) {
            for (int j = i+1; j < this.mainMatrix.length; j++) {
                tMatrix = this.getTMatrix(i, j);
                this.result.append("Утворена матриця: <br>");
                this.result.append(this.matrixView(tMatrix));
                this.result.append("<br>");
                this.result.append(this.generateMatrixMultiplyView(tMatrix, i, j));
                this.matrixMultiply(tMatrix, true);
                this.matrixMultiply(tMatrix, false);
                this.result.append("<br>Нова матриця <b>А</b>: <br>");
                this.result.append(this.matrixView(this.mainMatrix));
                this.result.append("<br>Нова матриця <b>b</b>: <br><br>");
                this.result.append(this.matrixView(this.bMatrix));
            }
        }
    }

    /**
     * Makes solution of SoLE.
     * @return string with html tags.
     */
    public String getSolution() {
        //StringBuilder string = new StringBuilder("Задана матриця А: <br>");
        Double x1, x2, x3;

        this.result.append("Задана матриця <b>А</b>: <br>");
        this.result.append(this.matrixView(this.mainMatrix));
        this.result.append("<br> Задана матриця <b>b</b>: <br>");
        this.result.append(this.matrixView(this.bMatrix));
        this.result.append("<b>Розв\'язок:</b> <br>");
        this.getTriangleMatrix();
        this.result.append("Ми прийшли до трикутного вигляду. Отримаємо розв\'язок системи: <br>");
        this.result.append("x3 = b3 / a33 = ");
        this.result.append(this.bMatrix[2]);
        this.result.append(" / ");
        this.result.append(this.mainMatrix[2][2]);
        this.result.append(" = ");
        x3 = this.bMatrix[2] / this.mainMatrix[2][2];
        this.result.append(x3);

        this.result.append("<br> Підставляємо х3 в друге рівняння: <br>");
        this.result.append("x2 = (b2 - a23 * x3) / a22 = (");
        this.result.append(this.bMatrix[1]);
        this.result.append(" - ");
        this.result.append(this.mainMatrix[1][2]);
        this.result.append(" * ");
        this.result.append(x3);
        this.result.append(") / ");
        this.result.append(this.mainMatrix[1][1]);
        x2 = (this.bMatrix[1] - (this.mainMatrix[1][2] * x3)) / this.mainMatrix[1][1];
        this.result.append(" = ");
        this.result.append(x2);

        this.result.append("<br> Підставляємо х2 та х3 в перше рівняння: <br>");
        this.result.append("x1 = (b1 - a12 * x2 - a13 * x3) / a11 = (");
        this.result.append(this.bMatrix[0]);
        this.result.append(" - ");
        this.result.append(this.mainMatrix[0][1]);
        this.result.append(" * ");
        this.result.append(x2);
        this.result.append(" - ");
        this.result.append(this.mainMatrix[0][2]);
        this.result.append(" * ");
        this.result.append(x3);
        this.result.append(") / ");
        this.result.append(this.mainMatrix[0][0]);
        this.result.append(" = ");
        x1 = (this.bMatrix[0] - (this.mainMatrix[0][1] * x2) - (this.mainMatrix[0][2] * x3)) / this.mainMatrix[0][0];
        this.result.append(x1);
        this.result.append("<br> Отже маємо <b>розв\'язок: <br>");
        Double[] solutionVector = {x1, x2, x3};
        this.result.append(this.matrixView(solutionVector));
        this.result.append("</b><br> Цей розв\'язок здійснений за допомогою веб-застосунку, розробленого Євгенієм Кізімом, " +
                "студентом групи КМ-52 НТУУ \"КПІ\" ім. І. Сікорського у 2017 році.");

        return this.result.toString();
    }

}

