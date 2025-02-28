package com.vir.isekai.unit.service.vtube

import com.vir.isekai.dto.command.VtuberCommand
import com.vir.isekai.entity.Vtuber
import com.vir.isekai.entity.enums.Platform
import com.vir.isekai.entity.enums.RaceType
import com.vir.isekai.repository.vtuber.VtuberRepository
import com.vir.isekai.service.vtuber.VtuberQueryService
import io.kotest.core.spec.style.StringSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

class VtuberQueryServiceUnitTest : StringSpec({
	val vtuberRepository: VtuberRepository = mockk()

	lateinit var vtuberQueryService: VtuberQueryService

	beforeTest {
		vtuberQueryService = VtuberQueryService(vtuberRepository)
	}

	val command =
		VtuberCommand.Save(
			1L,
			"버튜버1",
			4,
			160,
			"아르냥",
			RaceType.HUMAN,
			Platform.CHZZK,
		)

	"버튜버 저장 성공" {
		every { vtuberRepository.save(any(Vtuber::class)) } returns mockk()
		vtuberQueryService.saveVtuber(command)
		verify(exactly = 1) { vtuberRepository.save(any(Vtuber::class)) }
	}
})