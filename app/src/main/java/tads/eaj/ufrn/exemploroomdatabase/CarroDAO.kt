package tads.eaj.ufrn.exemploroomdatabase

import androidx.room.*

@Dao
interface CarroDao {
    @Insert
    fun inserir(carro: Carro): Long

    @Insert
    fun insereDois(c1:Carro, c2:Carro)

    @Delete
    fun deletar(carro: Carro): Int

    @Delete
    fun deletarVarios(vararg carros:Carro)

    @Query("DELETE FROM tabela_carro")
    fun deletaTodos()

    @Update
    fun atualizar(carro: Carro): Int

    @Query("SELECT * FROM tabela_carro")
    fun listAll(): Array<Carro>

    @Query("SELECT * FROM TABELA_CARRO WHERE id = :id")
    fun findById(id: Long): Carro

    @Query("SELECT * FROM TABELA_CARRO WHERE nome = :nome")
    fun findByName (nome: String) : Carro

}