package study.project.pokelytics.api.client

import kotlinx.coroutines.flow.Flow
import study.project.pokelytics.api.model.Ability
import study.project.pokelytics.api.model.ApiResourceList
import study.project.pokelytics.api.model.Berry
import study.project.pokelytics.api.model.BerryFirmness
import study.project.pokelytics.api.model.BerryFlavor
import study.project.pokelytics.api.model.Characteristic
import study.project.pokelytics.api.model.ContestEffect
import study.project.pokelytics.api.model.ContestType
import study.project.pokelytics.api.model.EggGroup
import study.project.pokelytics.api.model.EncounterCondition
import study.project.pokelytics.api.model.EncounterConditionValue
import study.project.pokelytics.api.model.EncounterMethod
import study.project.pokelytics.api.model.EvolutionChain
import study.project.pokelytics.api.model.EvolutionTrigger
import study.project.pokelytics.api.model.Gender
import study.project.pokelytics.api.model.Generation
import study.project.pokelytics.api.model.GrowthRate
import study.project.pokelytics.api.model.Item
import study.project.pokelytics.api.model.ItemAttribute
import study.project.pokelytics.api.model.ItemCategory
import study.project.pokelytics.api.model.ItemFlingEffect
import study.project.pokelytics.api.model.ItemPocket
import study.project.pokelytics.api.model.Language
import study.project.pokelytics.api.model.Location
import study.project.pokelytics.api.model.LocationArea
import study.project.pokelytics.api.model.LocationAreaEncounter
import study.project.pokelytics.api.model.Machine
import study.project.pokelytics.api.model.Move
import study.project.pokelytics.api.model.MoveAilment
import study.project.pokelytics.api.model.MoveBattleStyle
import study.project.pokelytics.api.model.MoveCategory
import study.project.pokelytics.api.model.MoveDamageClass
import study.project.pokelytics.api.model.MoveLearnMethod
import study.project.pokelytics.api.model.MoveTarget
import study.project.pokelytics.api.model.NamedApiResourceList
import study.project.pokelytics.api.model.Nature
import study.project.pokelytics.api.model.PalParkArea
import study.project.pokelytics.api.model.PokeathlonStat
import study.project.pokelytics.api.model.Pokedex
import study.project.pokelytics.api.model.Pokemon
import study.project.pokelytics.api.model.PokemonColor
import study.project.pokelytics.api.model.PokemonForm
import study.project.pokelytics.api.model.PokemonHabitat
import study.project.pokelytics.api.model.PokemonShape
import study.project.pokelytics.api.model.PokemonSpecies
import study.project.pokelytics.api.model.Region
import study.project.pokelytics.api.model.Stat
import study.project.pokelytics.api.model.SuperContestEffect
import study.project.pokelytics.api.model.Type
import study.project.pokelytics.api.model.Version
import study.project.pokelytics.api.model.VersionGroup

interface PokeApi {

    fun getBerryList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getBerryFirmnessList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getBerryFlavorList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getContestTypeList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getContestEffectList(offset: Int, limit: Int): Flow<ApiResourceList>

    fun getSuperContestEffectList(offset: Int, limit: Int): Flow<ApiResourceList>

    fun getEncounterMethodList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getEncounterConditionList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getEncounterConditionValueList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getEvolutionChainList(offset: Int, limit: Int): Flow<ApiResourceList>

    fun getEvolutionTriggerList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getGenerationList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getPokedexList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getVersionList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getVersionGroupList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getItemList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getItemAttributeList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getItemCategoryList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getItemFlingEffectList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getItemPocketList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getMoveList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getMoveAilmentList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getMoveBattleStyleList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getMoveCategoryList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getMoveDamageClassList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getMoveLearnMethodList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getMoveTargetList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getLocationList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getLocationAreaList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getPalParkAreaList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getRegionList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getMachineList(offset: Int, limit: Int): Flow<ApiResourceList>

    fun getAbilityList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getCharacteristicList(offset: Int, limit: Int): Flow<ApiResourceList>

    fun getEggGroupList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getGenderList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getGrowthRateList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getNatureList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getPokeathlonStatList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getPokemonList(offset: Int, limit: Int): Flow<List<Pokemon>>

    fun getPokemonColorList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getPokemonFormList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getPokemonHabitatList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getPokemonShapeList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getPokemonSpeciesList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getStatList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getTypeList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getLanguageList(offset: Int, limit: Int): Flow<NamedApiResourceList>

    fun getBerry(id: Int): Flow<Berry>

    fun getBerryFirmness(id: Int): Flow<BerryFirmness>

    fun getBerryFlavor(id: Int): Flow<BerryFlavor>

    fun getContestType(id: Int): Flow<ContestType>

    fun getContestEffect(id: Int): Flow<ContestEffect>

    fun getSuperContestEffect(id: Int): Flow<SuperContestEffect>

    fun getEncounterMethod(id: Int): Flow<EncounterMethod>

    fun getEncounterCondition(id: Int): Flow<EncounterCondition>

    fun getEncounterConditionValue(id: Int): Flow<EncounterConditionValue>

    fun getEvolutionChain(id: Int): Flow<EvolutionChain>

    fun getEvolutionTrigger(id: Int): Flow<EvolutionTrigger>

    fun getGeneration(id: Int): Flow<Generation>

    fun getPokedex(id: Int): Flow<Pokedex>

    fun getVersion(id: Int): Flow<Version>

    fun getVersionGroup(id: Int): Flow<VersionGroup>

    fun getItem(id: Int): Flow<Item>

    fun getItemAttribute(id: Int): Flow<ItemAttribute>

    fun getItemCategory(id: Int): Flow<ItemCategory>

    fun getItemFlingEffect(id: Int): Flow<ItemFlingEffect>

    fun getItemPocket(id: Int): Flow<ItemPocket>

    fun getMove(id: Int): Flow<Move>

    fun getMoveAilment(id: Int): Flow<MoveAilment>

    fun getMoveBattleStyle(id: Int): Flow<MoveBattleStyle>

    fun getMoveCategory(id: Int): Flow<MoveCategory>

    fun getMoveDamageClass(id: Int): Flow<MoveDamageClass>

    fun getMoveLearnMethod(id: Int): Flow<MoveLearnMethod>

    fun getMoveTarget(id: Int): Flow<MoveTarget>

    fun getLocation(id: Int): Flow<Location>

    fun getLocationArea(id: Int): Flow<LocationArea>

    fun getPalParkArea(id: Int): Flow<PalParkArea>

    fun getRegion(id: Int): Flow<Region>

    fun getMachine(id: Int): Flow<Machine>

    fun getAbility(id: Int): Flow<Ability>

    fun getCharacteristic(id: Int): Flow<Characteristic>

    fun getEggGroup(id: Int): Flow<EggGroup>

    fun getGender(id: Int): Flow<Gender>

    fun getGrowthRate(id: Int): Flow<GrowthRate>

    fun getNature(id: Int): Flow<Nature>

    fun getPokeathlonStat(id: Int): Flow<PokeathlonStat>

    fun getPokemon(id: Int): Pokemon

    fun getPokemonEncounterList(id: Int): Flow<List<LocationAreaEncounter>>

    fun getPokemonColor(id: Int): Flow<PokemonColor>

    fun getPokemonForm(id: Int): Flow<PokemonForm>

    fun getPokemonHabitat(id: Int): Flow<PokemonHabitat>

    fun getPokemonShape(id: Int): Flow<PokemonShape>

    fun getPokemonSpecies(id: Int): PokemonSpecies

    fun getStat(id: Int): Flow<Stat>

    fun getType(id: Int): Flow<Type>

    fun getLanguage(id: Int): Flow<Language>
}
