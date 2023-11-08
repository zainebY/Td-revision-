import java.util.*;

public class Agence {
    private String nom;
    private ListVoitures vs;
    private Map<Client, ListVoitures> ClientVoitureLoue;
    public Agence(String nom)
    {
        this.nom=nom;
    }
    public void ajoutVoiture(Voiture v) throws VoitureException
    {
        vs.ajoutVoiture(v);

    }
    public void suppVoiture(Voiture v)throws VoitureException
    {
        vs.supprimeVoiture(v);
    }
    public void loueClientVoiture(Client cl,Voiture v)throws VoitureException
    {
        if (v==null)
        {
            throw new VoitureException("La voiture est nulle");
        }
        if(vs.getVoitures().contains(v))
           loueClientVoiture(cl,v);

    }
    public void retourClientVoiture(Client cl , Voiture v) throws VoitureException
    {

    }
    public List<Voiture> selectVoitureSelonCritere(Critere c){
        List<Voiture> result = new ArrayList<>();
        for (Voiture v : vs.getVoitures()) {
            if (c.estSatisfaitPar(v)) {
                result.add(v);
            }
        }
        return result;
    }
    public Set<Client> ensembleClientsLoueurs(){
return ClientVoitureLoue.keySet();
    }
    public Collection<ListVoitures>
    collectionVoituresLouees(){
return ClientVoitureLoue.values();
    }
    public void afficheLesClientsEtLeursListesVoitures()
    {
        for (Map.Entry<Client, ListVoitures> entry:ClientVoitureLoue.entrySet()){
            Client cli= entry.getKey();
            ListVoitures lv=entry.getValue();
            System.out.println("Clients : "+cli+" , Voitures : "+lv);
        }

    }
    public Map<Client, ListVoitures> triCodeCroissant()
    {
        Map<Client,ListVoitures>lv=new TreeMap<>(new TriCodeCroissant());
        lv.putAll(ClientVoitureLoue);
        return lv;
    }
    public Map<Client, ListVoitures> triNomCroissant()
    {
        Map<Client,ListVoitures>lv=new TreeMap<>(new TriNomCroissant());
        lv.putAll(ClientVoitureLoue);
        return lv;
    }


}
