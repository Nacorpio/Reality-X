package com.nacorpio.nutilities.chemistry.element;

/**
 * Represents an element that can be used for making substances and compounds.<br>
 * You have to create a substance before using the element with energy.
 * @author Nacorpio
 *
 */
public class Element {

//	"Hydrogen": {
	//    "symbol" : "H",
	//    "atomic_number" : 1,
	//    "atomic_weight" : 1.00794,
	//    "density g/cm" : "0.0708 (@ -253°C)",
	//    "melting_point K" : 14.01,
	//    "boiling_point K" : 20.28,
	//    "atomic_radius pm" : 79,
	//    "covalent_radius pm" : 32,
	//    "ionic_radius pm" : "",
	//    "atomic_volume cm3/mol" : 14.1,
	//    "specific_heat (@20°C J/g mol)" : "14.267 (H-H)",
	//    "fusion_heat (kJ/mol)" : "0.117 (H-H)",
	//    "evaporation_heat (kJ/mol)" : "0.904 (H-H)",
	//    "thermal_conductivity (@25°C W/m K) " : 0.1815,
	//    "pauling_negativity" : 2.20,
	//    "first_ionizing kJ/mol" : 1311.3,
	//    "oxidation_states" : "1, -1",
	//    "electronic_configuration" : "1s¹",
	//    "lattice_structure" : "HEX",
	//    "lattice_constant ang" : 3.750
	//    }
	
	private String name;
	private String symbol;
	
	private int atomic_number;
	private float atomic_weight;
	private float density;
	
	private float melting_point;
	private float boiling_point;
	
	private float atomic_radius;
	private float covalent_radius;
	private float ionic_radius;
	
	private float atomic_volume;
	private float specific_heat;
	private float fusion_heat;
	private float evaporation_heat;
	
	private float thermal_conductivity;
	private float pauling_negativity;
	
	private float first_ionizing;
	private int[] oxidation_states;
	
	private String electronic_configuration;
	private String lattice_structure;
	private float lattice_constant;
	
	/**
	 * Create a new Element with the specified data.
	 * @param name the name of the Element.
	 * @param symbol the symbol of the Element.
	 * @param atomic_number the atomic number of the Element.
	 * @param atomic_weight the atomic weight of the Element.
	 * @param density the density of the Element.
	 * @param melting_point the melting point of the Element.
	 * @param boiling_point the boiling point of the Element.
	 * @param atomic_radius the atomic radius of the Element.
	 * @param covalent_radius the covalent radius of the Element.
	 * @param ionic_radius the ionic radius of the Element.
	 * @param atomic_volume the atomic volume of the Element.
	 * @param specific_heat the specific heat of the Element.
	 * @param fusion_heat the fusion heat of the Element.
	 * @param evaporation_heat the evaporation heat of the Element.
	 * @param thermal_conductivity the thermal conductivity of the Element.
	 * @param pauling_negativity the pauling negativity of the Element.
	 * @param first_ionizing the first ionizing of the Element.
	 * @param oxidation_states the oxidation states of the Element.
	 * @param electronic_configuration the electronic configuration of the Element.
	 * @param lattice_structure the lattice structure of the Element.
	 * @param lattice_constant the lattice constant of the Element.
	 */
	public Element(String name, String symbol, int atomic_number,
			float atomic_weight, float density, float melting_point,
			float boiling_point, float atomic_radius, float covalent_radius,
			float ionic_radius, float atomic_volume, float specific_heat,
			float fusion_heat, float evaporation_heat,
			float thermal_conductivity, float pauling_negativity,
			float first_ionizing, int[] oxidation_states,
			String electronic_configuration, String lattice_structure,
			float lattice_constant) {

		this.name = name;
		this.symbol = symbol;
		this.atomic_number = atomic_number;
		this.atomic_weight = atomic_weight;
		this.density = density;
		this.melting_point = melting_point;
		this.boiling_point = boiling_point;
		this.atomic_radius = atomic_radius;
		this.covalent_radius = covalent_radius;
		this.ionic_radius = ionic_radius;
		this.atomic_volume = atomic_volume;
		this.specific_heat = specific_heat;
		this.fusion_heat = fusion_heat;
		this.evaporation_heat = evaporation_heat;
		this.thermal_conductivity = thermal_conductivity;
		this.pauling_negativity = pauling_negativity;
		this.first_ionizing = first_ionizing;
		this.oxidation_states = oxidation_states;
		this.electronic_configuration = electronic_configuration;
		this.lattice_structure = lattice_structure;
		this.lattice_constant = lattice_constant;
		
	}
	
	/**
	 * Returns the name of the Element.
	 * @return the name.
	 */
	public final String getName() {
		return name;
	}
	
	/**
	 * Returns the symbol of the Element.<br>
	 * This will be the key for the registry.
	 * @return the symbol.
	 */
	public final String getSymbol() {
		return symbol;
	}
	
	/**
	 * Returns the atomic number of the Element.
	 * @return the atomic number.
	 */
	public final int getAtomicNumber() {
		return atomic_number;
	}
	
	/**
	 * Returns the atomic weight of the Element.
	 * @return the atomic weight.
	 */
	public final float getAtomicMass() {
		return atomic_weight;
	}
	
	/**
	 * Returns the density of the Element.
	 * @return the density.
	 */
	public final float getDensity() {
		return density;
	}
	
	/**
	 * Returns the melting point of the Element.
	 * @return the melting point.
	 */
	public final float getMeltingPoint() {
		return melting_point;
	}
	
	/**
	 * Returns the boiling point of the Element.
	 * @return the boiling point.
	 */
	public final float getBoilingPoint() {
		return boiling_point;
	}
	
	/**
	 * Returns the atomic radius of the Element.
	 * @return the atomic radius.
	 */
	public final float getAtomicRadius() {
		return atomic_radius;
	}
	
	/**
	 * Returns the covalent radius of the Element.
	 * @return the covalent radius.
	 */
	public final float getCovalentRadius() {
		return covalent_radius;
	}
	
	/**
	 * Returns the ionic radius of the Element.
	 * @return the ionic radius.
	 */
	public final float getIonicRadius() {
		return ionic_radius;
	}
	
	/**
	 * Returns the atomic volume of the Element.
	 * @return the atomic volume.
	 */
	public final float getAtomicVolume() {
		return atomic_volume;
	}
	
	/**
	 * Returns the specific heat of the Element.
	 * @return the specific heat.
	 */
	public final float getSpecificHeat() {
		return specific_heat;
	}
	
	/**
	 * Returns the fusion heat of the Element.
	 * @return the fusion heat.
	 */
	public final float getFusionHeat() {
		return fusion_heat;
	}
	
	/**
	 * Returns the evaporation heat of the Element.
	 * @return the evaporation heat.
	 */
	public final float getEvaporationHeat() {
		return evaporation_heat;
	}
	
	/**
	 * Returns the thermal conductivity of the Element.
	 * @return the thermal conductivity.
	 */
	public final float getThermalConductivity() {
		return thermal_conductivity;
	}
	
	/**
	 * Returns the pauling negativity of the Element.
	 * @return the pauling negativity.
	 */
	public final float getPaulingNegativity() {
		return pauling_negativity;
	}
	
	/**
	 * Returns the first ionizing of the Element.
	 * @return the first ionizing.
	 */
	public final float getFirstIonizing() {
		return first_ionizing;
	}
	
	/**
	 * Returns the oxidation states of the Element.
	 * @return the oxidation states.
	 */
	public final int[] getOxidationStates() {
		return oxidation_states;
	}

	/**
	 * Returns the electronic configuration of the Element.
	 * @return the electronic configuration.
	 */
	public final String getElectronicConfiguration() {
		return electronic_configuration;
	}
	
	/**
	 * Returns the lattice structure of the Element.
	 * @return the lattice structure.
	 */
	public final String getLatticeStructure() {
		return lattice_structure;
	}
	
	/**
	 * Returns the lattice constant of the Element.
	 * @return the lattice constant.
	 */
	public final float getLatticeConstant() {
		return lattice_constant;
	}
	
	public final boolean equals(Object par1) {
		
		if (par1 == null) {
			return false;
		}
		
		if (par1 instanceof Element) {
			
			Element var1 = (Element) par1;
			return symbol == var1.getSymbol();
			
		}
		
		return par1.equals(this);
		
	}
	
}
